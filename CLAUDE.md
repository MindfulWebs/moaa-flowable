# MOAA Platform Flowable Project Guidelines

## Build/Test/Lint Commands
- **Build all**: `mvn clean install` or `npm run all` (for js-based components)
- **Build specific module**: `mvn clean install -pl modules/<module-name>`
- **Run tests**: `mvn test` or `mvn test -Dtest=TestClassName`
- **Lint JS**: `npm run lint`
- **Build JS examples**: `cd bpmn-js-examples-main && npm run build`
- **Run single JS example**: `cd bpmn-js-examples-main/<example-dir> && npm start`

## Code Style Guidelines
- **Java**:
  - Follow standard Java naming conventions (camelCase for methods/variables, PascalCase for classes)
  - Respect Flowable's existing structure for API organization
  - Include proper Javadoc on public classes and methods
  - Use appropriate exception handling (avoid swallowing exceptions)
  
- **JavaScript**:
  - Use ES6+ features when possible
  - Maintain component structure consistent with existing examples
  - Format code with project's eslint rules
  - Use JSDoc for documenting functions

- **General**:
  - Follow existing patterns for similar functionality
  - Use appropriate logging levels
  - Write unit tests for new functionality