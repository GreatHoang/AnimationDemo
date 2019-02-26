pipeline {
	agent any
	stages {
		stage('build') {
			steps {
				sh 'echo "Say something"'
				sh '''
					echo "Multiline shell steps works too"
					ls -lah
				'''
			}
		}
		stage('deploy') {
			steps {
				timeout(time: 3, unit: 'MINUTES') {
					retry(5) {
						sh './flakey-deploy.sh'
					}
				}
			}
		}
	}
}