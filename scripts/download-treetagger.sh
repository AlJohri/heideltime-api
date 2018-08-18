#!/bin/bash

set -e

cd "$(dirname "$0")/.."

unamestr="$(uname)"
if [[ "$unamestr" == 'Linux' ]]; then
    platform='linux'
    tree_tagger_file='tree-tagger-linux-3.2.1.tar.gz'
elif [[ "$unamestr" == 'Darwin' ]]; then
    platform='macos'
    tree_tagger_file='tree-tagger-MacOSX-3.2.tar.gz'
else
    exit 1
fi

FOLDER=treetagger-$platform

if [ -f "$FOLDER/bin/tree-tagger" ]; then
	echo "treetagger already installed"
	exit 0
fi

mkdir -p $FOLDER

cd $FOLDER

wget http://www.cis.uni-muenchen.de/~schmid/tools/TreeTagger/data/$tree_tagger_file
wget http://www.cis.uni-muenchen.de/~schmid/tools/TreeTagger/data/tagger-scripts.tar.gz
wget http://www.cis.uni-muenchen.de/~schmid/tools/TreeTagger/data/english-par-linux-3.2-utf8.bin.gz
wget http://www.cis.uni-muenchen.de/~schmid/tools/TreeTagger/data/english-chunker-par-linux-3.2-utf8.bin.gz
wget http://www.cis.uni-muenchen.de/~schmid/tools/TreeTagger/data/install-tagger.sh

sh install-tagger.sh
