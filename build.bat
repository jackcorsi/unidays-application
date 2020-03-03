Pushd "%~dp0"

if not exist "out\production\unidays-application" mkdir out\production\unidays-application
javac -d out\production\unidays-application src\dev\jackcorsi\unidaysapplication\*.java

popd