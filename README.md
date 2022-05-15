# CoursesManagementApp

## Usage

## Testing

## Development

## Contributing

1. Fork it (<https://github.com/Oblivious-Oblivious/CoursesManagementApp/fork>)
2. Create your feature branch (`git checkout -b my-new-feature`)
3. Commit your changes (`git commit -am 'Add some feature'`)
4. Push to the branch (`git push origin my-new-feature`)
5. Create a new Pull Request

## Contributors

- [Kostas Georgiou](https://github.com/cs04333)                   - Scrum Master
- [Thanasis Papapostolou](https://github.com/Oblivious-Oblivious) - Maintainer
- [Thanasis Koureas](https://github.com/thanoskour)               - Product Owner


javac -classpath ./libs/jspec.jar:./libs/commons-math3-3.6.1.jar:./libs/sqlite-jdbc-3.36.0.3.jar:. app/src/**/*.java persistence/**/src/*.java persistence/*.java statistics/**/*.java statistics/*.java
javac -classpath ./libs/jspec.jar:./libs/commons-math3-3.6.1.jar:./libs/sqlite-jdbc-3.36.0.3.jar:. app/test/**/*.java app/test/TestRunner.java
java -classpath ./libs/jspec.jar:./libs/commons-math3-3.6.1.jar:./libs/sqlite-jdbc-3.36.0.3.jar:. app/test/TestRunner
