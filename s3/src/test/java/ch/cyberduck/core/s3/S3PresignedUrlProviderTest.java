package ch.cyberduck.core.s3;

/*
 * Copyright (c) 2002-2015 David Kocher. All rights reserved.
 * http://cyberduck.ch/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * Bug fixes, suggestions and comments should be sent to feedback@cyberduck.ch
 */

import ch.cyberduck.core.Credentials;
import ch.cyberduck.core.Host;
import ch.cyberduck.test.IntegrationTest;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

@Category(IntegrationTest.class)
public class S3PresignedUrlProviderTest extends AbstractS3Test {

    @Test
    public void testCreateEuWest() throws Exception {
        final Calendar expiry = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        expiry.add(Calendar.MILLISECOND, (int) TimeUnit.DAYS.toMillis(7));
        final String url = new S3PresignedUrlProvider(session).create(PROPERTIES.get("s3.secret"),
                "test-eu-west-1-cyberduck", "eu-west-1", "f", "GET", expiry.getTimeInMillis());
        assertNotNull(url);
        assertEquals("test-eu-west-1-cyberduck.s3.dualstack.eu-west-1.amazonaws.com", URI.create(url).getHost());
        final HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        assertEquals(404, connection.getResponseCode());
    }

    @Test
    public void testCreateEuCentral() throws Exception {
        final Calendar expiry = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        expiry.add(Calendar.MILLISECOND, (int) TimeUnit.DAYS.toMillis(7));
        final String url = new S3PresignedUrlProvider(session).create(PROPERTIES.get("s3.secret"),
                "test-eu-central-1-cyberduck", "eu-central-1", "f", "GET", expiry.getTimeInMillis());
        assertNotNull(url);
        assertEquals("test-eu-central-1-cyberduck.s3.dualstack.eu-central-1.amazonaws.com", URI.create(url).getHost());
    }

    @Test
    public void testCreateVirtualHost() throws Exception {
        final Calendar expiry = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        expiry.add(Calendar.MILLISECOND, (int) TimeUnit.DAYS.toMillis(7));
        final String url = new S3PresignedUrlProvider(virtualhost).create(System.getProperties().getProperty("s3.secret"),
                "test-eu-central-1-cyberduck", "eu-central-1", "f", "GET", expiry.getTimeInMillis());
        assertNotNull(url);
        assertEquals("test-eu-central-1-cyberduck.s3.dualstack.eu-central-1.amazonaws.com", URI.create(url).getHost());
        assertTrue(url, url.startsWith("https://test-eu-central-1-cyberduck.s3.dualstack.eu-central-1.amazonaws.com/f"));
    }

    @Test
    public void testCreateEuCentralAtSign() throws Exception {
        final Calendar expiry = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        expiry.add(Calendar.MILLISECOND, (int) TimeUnit.DAYS.toMillis(7));
        final String url = new S3PresignedUrlProvider(session).create(PROPERTIES.get("s3.secret"),
                "test-eu-central-1-cyberduck", "eu-central-1", "@f", "GET", expiry.getTimeInMillis());
        assertNotNull(url);
        assertEquals("test-eu-central-1-cyberduck.s3.dualstack.eu-central-1.amazonaws.com", URI.create(url).getHost());
        assertTrue(url, url.startsWith("https://test-eu-central-1-cyberduck.s3.dualstack.eu-central-1.amazonaws.com/%40f"));
    }

    @Test
    public void testCreateDefault() throws Exception {
        final Calendar expiry = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        expiry.add(Calendar.MILLISECOND, (int) TimeUnit.DAYS.toMillis(7));
        final String url = new S3PresignedUrlProvider(session).create(PROPERTIES.get("s3.secret"),
                "test-us-east-1-cyberduck", "us-east-1", "f", "GET", expiry.getTimeInMillis());
        assertNotNull(url);
        assertEquals("test-us-east-1-cyberduck.s3.dualstack.us-east-1.amazonaws.com", URI.create(url).getHost());
        assertTrue(url.startsWith("https://test-us-east-1-cyberduck.s3.dualstack.us-east-1.amazonaws.com/f"));
        final HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        assertEquals(404, connection.getResponseCode());
    }

    @Test
    public void testCustomHostname() {
        final Calendar expiry = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        expiry.add(Calendar.MILLISECOND, (int) TimeUnit.DAYS.toMillis(7));
        final Host host = new Host(new S3Protocol(), "h");
        final S3Session session = new S3Session(host);
        final String url = new S3PresignedUrlProvider(session).create(PROPERTIES.get("s3.secret"),
                "test-us-east-1-cyberduck", "us-east-1", "f", "GET", expiry.getTimeInMillis());
        assertNotNull(url);
        assertEquals("test-us-east-1-cyberduck.h", URI.create(url).getHost());
    }

    @Test
    public void testCustomHostnameWithRegion() {
        final Calendar expiry = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        expiry.add(Calendar.MILLISECOND, (int) TimeUnit.DAYS.toMillis(7));
        final Host host = new Host(new S3Protocol(), "s3.eu-central-1.wasabisys.com");
        final S3Session session = new S3Session(host);
        final String url = new S3PresignedUrlProvider(session).create(PROPERTIES.get("s3.secret"),
                "cyberduck", "eu-central-1", "f", "GET", expiry.getTimeInMillis());
        assertNotNull(url);
        assertEquals("cyberduck.s3.eu-central-1.wasabisys.com", URI.create(url).getHost());
    }

    @Test
    public void testDefaultHostnameWithRegionWithProfile() {
        final Calendar expiry = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        expiry.add(Calendar.MILLISECOND, (int) TimeUnit.DAYS.toMillis(7));
        final Host host = new Host(new S3Protocol() {
            @Override
            public String getDefaultHostname() {
                return "wasabisys.com";
            }
        }, "wasabisys.com");
        final S3Session session = new S3Session(host);
        final String url = new S3PresignedUrlProvider(session).create(PROPERTIES.get("s3.secret"),
                "cyberduck", "eu-central-1", "f", "GET", expiry.getTimeInMillis());
        assertNotNull(url);
        assertEquals("cyberduck.wasabisys.com", URI.create(url).getHost());
    }

    @Test
    public void testDefaultHostnameWithProfile() {
        final Calendar expiry = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        expiry.add(Calendar.MILLISECOND, (int) TimeUnit.DAYS.toMillis(7));
        final Host host = new Host(new S3Protocol() {
            @Override
            public String getDefaultHostname() {
                return "h";
            }
        }, "h");
        final S3Session session = new S3Session(host);
        final String url = new S3PresignedUrlProvider(session).create(PROPERTIES.get("s3.secret"),
                "test-us-east-1-cyberduck", "us-east-1", "f", "GET", expiry.getTimeInMillis());
        assertNotNull(url);
        assertEquals("test-us-east-1-cyberduck.h", URI.create(url).getHost());
    }

    @Test
    public void testDnsBucketNamingDisabled() {
        final Host host = new Host(new S3Protocol(), new S3Protocol().getDefaultHostname(), new Credentials(
                PROPERTIES.get("s3.key"), PROPERTIES.get("s3.secret")
        )) {
            @Override
            public String getProperty(final String key) {
                if("s3.bucket.virtualhost.disable".equals(key)) {
                    return String.valueOf(true);
                }
                return super.getProperty(key);
            }
        };
        final S3Session session = new S3Session(host);
        final Calendar expiry = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        expiry.add(Calendar.MILLISECOND, (int) TimeUnit.DAYS.toMillis(7));
        final String url = new S3PresignedUrlProvider(session).create(PROPERTIES.get("s3.secret"),
                "test-bucket", "region", "f", "GET", expiry.getTimeInMillis());
        assertNotNull(url);
        assertEquals("s3.dualstack.region.amazonaws.com", URI.create(url).getHost());
        assertEquals("/test-bucket/f", URI.create(url).getPath());
    }
}
