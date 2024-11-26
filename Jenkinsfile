// Jenkinsfile (Declarative Pipeline)
// Author:CodeFilmsPLC
pipeline {
   agent any
   
    parameters{
       string(name:'PID', defaultValue: '$2', description: 'java pid number')
       string(name:'PRINT',defaultValue: "'{print \$2}'", description:'print')
   } 
   
   stages {
      stage('Build') {
         steps {
            echo 'Building stage'     
            sh 'mvn clean package'
            
            
         }
      }
      
      stage('Deploy') {
         when {
            expression {
               currentBuild.result == null || currentBuild.result == 'SUCCESS'
            }
              
         }
         
         environment {
            //    DEBUG_FLAGS = '-g'
            NAME = """${sh(
            returnStdout:true,
            script: 'mvn -q -DforceStdout help:evaluate -Dexpression=project.name'
            )
         }"""
         // mvn -q -DforceStdout help:evaluate -Dexpression=project.name
         VERSION =  """${sh(
         returnStdout: true,
         script:'mvn -q -DforceStdout help:evaluate -Dexpression=project.version'
         )
      }"""
      
   }
   
   // jenkins over ssh --
   steps {
      sh 'printenv'
      sh 'echo $NAME'
      sh 'echo $VERSION'
      sh 'echo ${PRINT}'
       sh 'echo ${PID}' // :(
      echo 'delivering app for deployment.'
      echo '@@ remove old build'
      sh 'ssh  appuser@192.168.0.190 "rm -rf /home/appuser/apps/$NAME-$VERSION.war > /dev/null 2>&1 &"'
      echo '@@ copy new build'
      sh 'scp ./target/$NAME.war appuser@192.168.0.190:/home/appuser/apps/'
      echo '@@ kill running java process @@'
     // sh("lsof -i | grep java > PID.txt && awk '{print \$2}' PID.txt | xargs kill -9")  

     //--     
     // > PID.txt && awk {print \$2} PID.txt | xargs kill -9
     // > /dev/null 2>&1 &
     // with param ..
     // use double quote
     // add kill
     // nothing change
      // here.
      // && awk \'{print \'$2\'}\' PID.txt | xargs kill -9
      // .
      sh 'ssh  appuser@192.168.0.190 "lsof -i:8082 | grep java > PID.txt && awk ${PRINT} PID.txt | xargs kill -9 > /dev/null 2>&1 &"'
      echo '@@ starting java app @@'
      sh 'ssh  appuser@192.168.0.190 "nohup java -jar /home/appuser/apps/$NAME-$VERSION.war > /dev/null 2>&1 &"'
   }
   
   
}


stage('End') {
   steps {
      echo 'done with deployment'
      sh 'echo "done"'
      sh 'exit'
   }
}

}

}