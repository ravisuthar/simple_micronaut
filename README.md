# simple_micronaut
Micronaut

GraphQL Endpoint : http://localhost:8080/graphiql

Swagger Endpoint : http://localhost:8080/swagger/swagger-server-0.1.yml

API Versioning:
   parameter based:
          http://localhost:8080/version/hello?v=1            =>hello from version-1
          http://localhost:8080/version/hello?api-version=2  =>hello from version-2
          http://localhost:8080/version/hello                =>hello from version-3 (default)
   Header based:
         http://localhost:8080/version/hello with header X-API-VERSION=1    =>hello from version-1
         http://localhost:8080/version/hello with header Accept-Version=2   =>hello from version-2
         http://localhost:8080/version/hello with no header                 =>hello from version-3 (default)
