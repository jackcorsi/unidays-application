Pushd "%~dp0"

cd out\production\unidays-application
java dev.jackcorsi.unidaysapplication.Test < ../../../test-cases.txt

cd ../../..

popd