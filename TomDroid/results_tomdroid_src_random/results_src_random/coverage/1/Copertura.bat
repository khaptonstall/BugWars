set EMMA=java -cp %EMULATORPATH%\lib\emma_device.jar emma
%EMMA% merge -in coverage.em,coverage_1_0.ec -out coverage0.es
%EMMA% report -r html -sp %APKPATH%\src -Dreport.sort=+name -in coverage0.es