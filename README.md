OpenRandomFile
=============

OpenRandomFile is a tool for opening random file(s) according to some given parameters.
It is written in Java and uses a CLI.

Usage
-------

java jar OpenRandomFile.java [operators]

The operators are:
* -dir= `list of [String] seperated by |` Dir(s) to get files from. If omitted then OpenRandomFile searches the dir it was executed from.
* -delay= `[int]` Msec delay opening a file. If omitted then no delay.
* -filetypes=`list of [String] seperated by ,` Allowed extensions. If omitted then all extensions are OK.
* -open=`[true/false|yes/no|Y/N]` Open file(s) when selecting them. If omitted then yes.
* -numbfiles=`[int]` Number of files to select. If omitted then 1.
* -subfolder=`[true/false|yes/no|Y/N]` Allow search in subfolders. If omitted then yes.

Misc
------------

By [rattmuffen](http://www.rattmuffen.st) 2012.

