
pipeline {
    
	agent none
  
	// pipeline must complete in 10 minutes
	options {
		timeout(time: 10, unit: 'MINUTES') 
		buildDiscarder(logRotator(numToKeepStr: '10', artifactNumToKeepStr: '5'))
	}

	stages {
    	
		
		
		stage('analysis') {
			agent any
			steps {
				script {
					SCANNER_HOME = tool 'sonarscanner';	
				}
				withSonarQubeEnv('sonarserver') {
					sh "${SCANNER_HOME}/bin/sonar-scanner"
				}	
			}
		}
	}
	
}





