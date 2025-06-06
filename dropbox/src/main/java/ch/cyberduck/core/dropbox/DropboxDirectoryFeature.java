package ch.cyberduck.core.dropbox;

/*
 * Copyright (c) 2002-2016 iterate GmbH. All rights reserved.
 * https://cyberduck.io/
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
 */

import ch.cyberduck.core.LocaleFactory;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.PathContainerService;
import ch.cyberduck.core.exception.BackgroundException;
import ch.cyberduck.core.exception.InvalidFilenameException;
import ch.cyberduck.core.features.Directory;
import ch.cyberduck.core.transfer.TransferStatus;

import java.text.MessageFormat;

import com.dropbox.core.DbxException;
import com.dropbox.core.v2.files.CreateFolderResult;
import com.dropbox.core.v2.files.DbxUserFilesRequests;

public class DropboxDirectoryFeature implements Directory<String> {

    private final DropboxSession session;
    private final PathContainerService containerService;

    public DropboxDirectoryFeature(final DropboxSession session) {
        this.session = session;
        this.containerService = new DropboxPathContainerService();
    }

    @Override
    public Path mkdir(final Path folder, final TransferStatus status) throws BackgroundException {
        try {
            final CreateFolderResult result = new DbxUserFilesRequests(session.getClient(folder.getParent()))
                    .createFolderV2(containerService.getKey(folder), false);
            return new Path(folder).withAttributes(new DropboxAttributesFinderFeature(session).toAttributes(result.getMetadata()));
        }
        catch(DbxException e) {
            throw new DropboxExceptionMappingService().map("Cannot create folder {0}", e, folder);
        }
    }

    @Override
    public void preflight(final Path workdir, final String filename) throws BackgroundException {
        if(!DropboxTouchFeature.validate(filename)) {
            throw new InvalidFilenameException(MessageFormat.format(LocaleFactory.localizedString("Cannot create folder {0}", "Error"), filename));
        }
    }
}
