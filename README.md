# heideltime-api

A simple API for the [heideltime](https://github.com/HeidelTime/heideltime/) temporal tagger powered via the [Stanford POS Tagger](https://nlp.stanford.edu/software/tagger.html).

Components:
- Heideltime (Standalone) [2.2.1](https://github.com/HeidelTime/heideltime/releases/tag/VERSION2.2.1)
- Stanford POS Tagger (English) [3.3.1](https://nlp.stanford.edu/software/stanford-postagger-full-2014-01-04.zip)
	- Using the `english-bidirectional-distsim.tagger` model
- [TreeTagger](http://www.cis.uni-muenchen.de/~schmid/tools/TreeTagger/)
	- TreeTagger is not included in this repository because of its [license terms](http://www.cis.uni-muenchen.de/~schmid/tools/TreeTagger/Tagger-Licence).
	- We download it using a script instead: [./scripts/download-treetagger.sh](./scripts/download-treetagger.sh).

## Usage

See [./scripts/integration_test](./scripts/integration_test) for usage.

#### Docker

```
docker-compose up --build
./scripts/integration_test
```

#### Local
```
./scripts/bootstrap
./scripts/run
./scripts/integration_test
```
