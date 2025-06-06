package ch.cyberduck.core.smb;

/*
 * Copyright (c) 2002-2023 iterate GmbH. All rights reserved.
 * https://cyberduck.io/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

import ch.cyberduck.core.exception.ConnectionTimeoutException;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import com.hierynomus.msdfsc.DFSException;
import com.hierynomus.mserref.NtStatus;
import com.hierynomus.mssmb2.SMBApiException;
import com.hierynomus.protocol.transport.TransportException;
import com.hierynomus.smbj.common.SMBRuntimeException;

import static com.hierynomus.mssmb2.SMB2MessageCommandCode.SMB2_CREATE;
import static org.junit.Assert.assertEquals;

public class SMBExceptionMappingServiceTest {

    @Test
    public void map() {
        assertEquals("Interoperability failure", new SMBExceptionMappingService().map(new SMBRuntimeException("")).getMessage());
        assertEquals("Please contact your web hosting service provider for assistance.", new SMBExceptionMappingService().map(new SMBRuntimeException("")).getDetail());
        assertEquals("STATUS_OBJECT_NAME_NOT_FOUND (0xc0000034). Please contact your web hosting service provider for assistance.",
                new SMBExceptionMappingService().map(new SMBApiException(NtStatus.STATUS_OBJECT_NAME_NOT_FOUND.getValue(), SMB2_CREATE,
                        "Create failed for \\\\localhost\\user\\Dk9I5nTZ", null)).getDetail());
        assertEquals(ConnectionTimeoutException.class,
                new SMBExceptionMappingService().map(
                        new SMBApiException(NtStatus.STATUS_OTHER.getValue(), SMB2_CREATE, new DFSException(new TransportException(new ExecutionException(new SMBRuntimeException(new TimeoutException())))))
                ).getClass());
    }
}