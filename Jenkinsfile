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
    stage('Browser Tests') {
      steps {
        parallel(
          "Firefox": {
            sh 'echo \'setting up selenium environment\''
            sh 'ping -c 5 localhost'
            
          },
          "Safari": {
            sh 'echo \'setting up selenium environment\''
            sh 'ping -c 8 localhost'
            
          },
          "Chrome": {
            sh 'echo \'setting up selenium environment\''
            sh 'ping -c 3 localhost'
            
          },
          "Internet Explorer": {
            sh 'echo \'setting up selenium environment\''
            sh 'ping -c 4 localhost'
            
          }
        )
      }
    }
    stage('Static Analysis') {
      	steps {
				 sh "sonar-scanner -e -Dsonar.host.url=http://localhost:9000 -Dsonar.projectName='javaproj' -Dsonar.projectVersion='0.1' -Dsonar.login='admin' -Dsonar.password='admin' -Dsonar.sources='./src/main' -Dsonar.java.source='1.8' -Dsonar.java.binaries='target/classes/*' -Dsonar.jacoco.reportPath='.target/jacoco.exec' -Dsonar.java.coveragePlugin='jacoco' -Dsonar.coverage.exclusions='*/test/**/*'"
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
	

