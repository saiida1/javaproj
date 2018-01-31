
pipeline {
    agent {
    docker {
      image 'maven'
    }
    
}

	stages {
    	
		
		stage ('build') {	          
			agent any
				steps {	    
					sh 'mvn install'
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
					SCANNER_HOME = tool 'sonarScanner';	
				}
				withSonarQubeEnv('MySonarServer') {
					sh "${SCANNER_HOME}/bin/sonar-scanner"
				}	
			}
		}
	}
	
}

