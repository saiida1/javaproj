
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
		 stage('SonarQube analysis') {
    // requires SonarQube Scanner 2.8+
    def scannerHome = tool 'SonarQube Scanner 2.8';
    withSonarQubeEnv('MySonarQubeServer') {
      sh "${scannerHome}/bin/sonar-scanner"
    }
  }
	}
	
}





