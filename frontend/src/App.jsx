import { BrowserRouter, Routes, Route } from "react-router-dom";
import TodosList from "./components/todo/TodosList";
import LoginComponent from "./components/todo/LoginComponent";
import WelcomeComponent from "./components/WelcomeComponent";
import ErrorComponent from "./components/ErrorComponent";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<WelcomeComponent />}></Route>
          <Route path="/login" element={<LoginComponent />}></Route>
          <Route path="/todos" element={<TodosList />}></Route>
          <Route path="*" element={<ErrorComponent />}></Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
