import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("Should return a student")
    request {
        method GET()
        url("/student-service/student"){
            queryParameters {
                parameter("rollNo", "Y4CS48")
            }
        }
    }
    response {
        status(200)
        headers {
            contentType applicationJson()
        }
        body(
                rollNo: "Y4CS48",
                name: "Sree D",
                branch: "Computer Science",
                college: "SVU"
        )
    }
}
