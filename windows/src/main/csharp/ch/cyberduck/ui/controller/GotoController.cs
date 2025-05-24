// 
// Copyright (c) 2010-2016 Yves Langisch. All rights reserved.
// http://cyberduck.io/
// 
// This program is free software; you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation; either version 2 of the License, or
// (at your option) any later version.
// 
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU General Public License for more details.
// 
// Bug fixes, suggestions and comments should be sent to:
// feedback@cyberduck.io
// 

using System;
using System.Drawing;
using System.Windows.Forms;
using ch.cyberduck.core;
using Ch.Cyberduck.Core;
using static Ch.Cyberduck.ImageHelper;
using java.util;

namespace Ch.Cyberduck.Ui.Controller
{
    internal class GotoController : FileController
    {
        public GotoController(IPromptView view, BrowserController browserController) : base(view, browserController)
        {
            PrefilledText = browserController.Workdir.getAbsolute();
        }

        public override Image IconView
        {
            get { return IconProvider.GetFileIcon(string.Empty, true, true, false); }
        }

        public override void Callback(DialogResult result)
        {
            if (DialogResult.OK == result && !String.IsNullOrEmpty(View.InputText) &&
                !View.InputText.Trim().Equals(String.Empty))
            {
                GotoFolder(BrowserController.Workdir, View.InputText);
            }
        }

        protected override bool ValidateInput()
        {
            return Utils.IsNotBlank(View.InputText);
        }

        private void GotoFolder(Path workdir, String input)
        {
            String delimiter = Path.DELIMITER.ToString();
            if (!input.EndsWith(delimiter))
            {
                String parentPath = PathNormalizer.parent(input, Path.DELIMITER);
                Path dir = PathNormalizer.compose(workdir, parentPath == null ? delimiter : parentPath);
                Path file = new Path(dir, PathNormalizer.name(input), EnumSet.of(AbstractPath.Type.file));
                BrowserController.SetWorkdir(dir, file);
            }
            else
            {
                Path dir = PathNormalizer.compose(workdir, input);
                if (workdir.getParent().Equals(dir))
                {
                    BrowserController.SetWorkdir(dir, workdir);
                }
                else
                {
                    BrowserController.SetWorkdir(dir);
                }
            }
        }
    }
}
