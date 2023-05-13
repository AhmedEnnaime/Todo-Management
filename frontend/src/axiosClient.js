import axios from "axios";

const client = axios.create({
  baseURL: "http://localhost:8080/api/todos",
  headers: {
    "Content-Type": "application/json",
    Accept: "application/json",
  },
});

export default client;
