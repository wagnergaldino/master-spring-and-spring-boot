import { useEffect, useState } from "react";
import { deleteTodoApi, retrieveAllTodosFromUsernameApi } from './api/TodoApiService'
import { useAuth } from "./security/AuthContext";
import { useNavigate } from "react-router-dom";

export default function ListTodosComponent() {

    const authContext = useAuth()
    const username = authContext.username

    const navigate = useNavigate()

    const [todos, setTodos] = useState([])
    useEffect( () => refreshTodos(), [] )

    const [message, setMessage] = useState(null)

    function refreshTodos() {
        retrieveAllTodosFromUsernameApi(username)
        .then( response => {
            setTodos(response.data)
        })
        .catch( error => console.log(error) )
    }

    function deleteTodo(id) {
        deleteTodoApi(username, id)
        .then(
            () => {
                setMessage(`Delete todo with id ${id} successful`)
                refreshTodos()
            }
        )
        .catch( error => console.log(error) )
    }

    function updateTodo(id) {
        navigate(`/todo/${id}`)
    }

    function addNewTodo() {
        navigate(`/todo/-1`)
    }
    
    return(
        <div className="container">
            <h1>List Todos Component</h1>
            {message && <div className="alert alert-warning">{message}</div>}
            <div>List Todos Details</div>
            <div>
                <table className="table">
                    <thead>
                        <tr>
                            <th>id</th>
                            <th>description</th>
                            <th>is done?</th>
                            <th>date</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            todos.map(
                                todo => (
                                    <tr key={todo.id}>
                                        <td>{todo.id}</td>
                                        <td>{todo.description}</td>
                                        <td>{todo.done.toString()}</td>
                                        {/* <td>{todo.targetDate.toDateString()}</td> */}
                                        <td>{todo.targetDate.toString()}</td>
                                        <td><button className="btn btn-warning" onClick={() => deleteTodo(todo.id)}>Delete</button></td>
                                        <td><button className="btn btn-success" onClick={() => updateTodo(todo.id)}>Update</button></td>
                                    </tr>
                                )
                            )
                        }
                    </tbody>
                </table>
            </div>
            <div className="btn btn-info m-5" onClick={addNewTodo}>Add New Todo</div>
        </div>
    )
}