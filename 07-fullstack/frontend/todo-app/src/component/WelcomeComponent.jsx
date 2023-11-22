import {useParams, Link} from 'react-router-dom'
import { useState } from "react";
import { retrieveHelloWorldPathVariable } from './api/HelloWorldApiService'
import { useAuth } from './security/AuthContext';

export default function WelcomeComponent() {

    const {username} = useParams()
    const authContext = useAuth()
    const [message, setMessage] = useState(null)

    function callHelloWorldRestApi() {

        // retrieveHelloWorldBean()
        // .then( (response) => successfulResponse(response) )
        // .catch( (error) => errorResponse(error) )
        // .finally( () => console.log('cleanup') )

        retrieveHelloWorldPathVariable(username, authContext.token)
        .then( (response) => successfulResponse(response) )
        .catch( (error) => errorResponse(error) )
        .finally( () => console.log('cleanup') )

        // axios.get('http://localhost:8080/hello-world')
        // .then( (response) => successfulResponse(response) )
        // .catch( (error) => errorResponse(error) )
        // .finally( () => console.log('cleanup') )
    }

    function successfulResponse(response) {
        console.log(response)
        setMessage(response.data.message)
    }

    function errorResponse(error) {
        console.log(error)
    }

    return(
        <div className="WelcomeComponent">
            <h1>Welcome Component</h1>
            <div>
                Welcome {username}<br/>
            </div>
            <div>
                Manage <Link to='/todos'>your todos</Link><br/>
            </div>
            <div>
                <button className="btn btn-success" onClick={callHelloWorldRestApi}>Call Hello World Rest API</button>
            </div>
            <div className="text-info">{message}</div>
        </div>
    )
}