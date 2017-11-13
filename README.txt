The library struts-layout is not maintain anymore by the fundation.
You have to take the jar and put it locally in your maven.

Deploy the lib struts-layout-1.3.jar in your local repo.

mvn install:install-file -Dfile=lib\struts-layout-1.3.jar -DgroupId=struts
-DartifactId=struts-layout -Dversion=1.3 -Dpackaging=jar (Ou appeler addStrutsLayoutRepoLocal.bat)