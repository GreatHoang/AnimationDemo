pipeline {
	agent any

	environment {
		DISABLE_AUTH = 'true'
		DB_ENGINE = 'sqlite'
		NAME = 'newbie'
	}

	stages {
		stage('build') {
			steps {
				sh 'echo "Say something"'
				sh '''
					echo "Multiline shell steps works too"
					ls -lah
				'''
				sh 'chmod +x gradlew'
				sh './gradlew build'
			}
		}
		stage('deploy') {
			steps {
				timeout(time: 3, unit: 'MINUTES') {
					retry(5) {
						sh 'echo "retry ++"'
					}
				}
			}
		}
		stage('environment') {
			steps {
				sh 'printenv'
				sh 'echo "show name: $NAME"'
			}
		}
		stage('test') {
			steps {
				sh './gradlew check'
			}
		}
	}
	post {
		always {
			echo 'This will always run'
			archiveArtifacts artifacts: 'build/libs/**/*.jar', fingerprint: true
			junit 'build/reports/**/*.xml'
		}
		success {
			echo 'This will run only if successful'
		}
		failure {
			echo 'This will run only if failed'
		}
		unstable {
			echo 'This will run only if the run was marked as unstable'
		}
		changed {
			echo 'This will run only if the state of the Pipeline has changed'
			echo 'For example ion the Pipeline was previously failing but is now successful'
		}
	}
}