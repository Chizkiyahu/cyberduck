#!/usr/bin/env bash

#  Copyright (c) 2012 David Kocher. All rights reserved.
#  http://cyberduck.ch/
#
#  This program is free software; you can redistribute it and/or modify
#  it under the terms of the GNU General Public License as published by
#  the Free Software Foundation; either version 2 of the License, or
#  (at your option) any later version.
#
#  This program is distributed in the hope that it will be useful,
#  but WITHOUT ANY WARRANTY; without even the implied warranty of
#  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#  GNU General Public License for more details.
#
#  Bug fixes, suggestions and comments should be sent to:
#  dkocher@cyberduck.ch

tiff="/usr/bin/tiffutil"

usage() {
    echo "Converts *.png and *@2x.png to .tiff"
	echo "	  Usage: combine.sh [--source <png>] --run"
}

run() {
    for name in `ls . | grep @2x.png`; do
		png=`basename $name @2x.png`
		tiff;
    done;
}

tiff() {
	echo "$tiff -cathidpicheck $png.png $png@2x.png -out $png.tiff"
    $tiff -cathidpicheck $png.png $png@2x.png -out $png.tiff
}

while [ "$1" != "" ] # When there are arguments...
    do case "$1" in 
            -r | --run)
                run;
                echo "*** DONE. ***";
                exit 0;
            ;; 
            -s | --source)
			    shift;
			    png=$1;
			    tiff;
                echo "*** DONE. ***";
                exit 0;
            ;; 
            *)  
    			echo "Option [$1] not one of  [--run]"; # Error (!)
    			exit 1
            ;; # Abort Script Now
    esac;
done;

usage;