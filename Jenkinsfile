pipeline {
  agent {
    docker {
      image 'maven'
    }
    
  }
  stages {
    stage('Build') {
      steps {
        sh 'mvn clean source:jar package'
      }
    }
    
    stage('Static Analysis') {
      	steps {
				script {
				def	SCANNER_HOME = tool 'sonarScanner';	
				}
				withSonarQubeEnv('SonarQube 6.7') {
					sh "${SCANNER_HOME}/bin/sonar-scanner"
				}	
			}
    }
    stage('Deploy') {
      steps {
        sh 'mvn source:jar package -Dmaven.test.skip'
      }
    }
  }
  post {
    always {
      junit '**/target/surefire-reports/TEST-*.xml'
      archive '**/target/*.jar'
    }  
}
}
	

