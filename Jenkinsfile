
pipeline {
    
	agent none
  
	// pipeline must complete in 10 minutes
	options {
		timeout(time: 10, unit: 'MINUTES') 
		buildDiscarder(logRotator(numToKeepStr: '10', artifactNumToKeepStr: '5'))
	}

	stages {
    	
		stage ('build') {	          
			agent any
				steps {	    
					sh 'mvn verify'
			}
			post {
				always {
					archiveArtifacts artifacts: 'target/*.jar', fingerprint: true 
				}
			}
		}
		
		stage('analysis') {
			agent any
			steps {
				script {
					SCANNER_HOME = tool 'sonarscanner';	
				}
				withSonarQubeEnv('sonarserver') {
					sh "/etc/sonar-runner-2.4/bin/sonar-scanner"
				}	
			}
		}
	}
	
}





