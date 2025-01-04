import React, { useState } from "react";
import axios from "axios";

const LoginPage = () => {
    
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [message, setMessage] = useState("");
  const [isLogin, setIsLogin] = useState(true);

  const handleRegister = async () => {
    try {
      const response = await axios.post("http://localhost:8080/api/users/register", { username, password });
      setMessage(response.data);
    } catch (error) {
      setMessage("Registration failed");
    }
  };

  const handleLogin = async () => {
    try {
      const response = await axios.post("http://localhost:8080/api/users/login", { username, password });
      setMessage(response.data);
    } catch (error) {
      setMessage("Login failed");
    }
  };

  return (
    <div style={{ textAlign: "center", marginTop: "50px" }}>
      <h1>{isLogin ? "Login" : "Register"}</h1>
      <input
        type="text"
        placeholder="Username"
        value={username}
        onChange={(e) => setUsername(e.target.value)}
        style={{ margin: "10px", padding: "5px" }}
      />
      <input
        type="password"
        placeholder="Password"
        value={password}
        onChange={(e) => setPassword(e.target.value)}
        style={{ margin: "10px", padding: "5px" }}
      />
      <br />
      <button onClick={isLogin ? handleLogin : handleRegister}>
        {isLogin ? "Login" : "Register"}
      </button>
      <button onClick={() => setIsLogin(!isLogin)} style={{ marginLeft: "10px" }}>
        Switch to {isLogin ? "Register" : "Login"}
      </button>
      <p>{message}</p>
    </div>
  );
};

export default LoginPage;
