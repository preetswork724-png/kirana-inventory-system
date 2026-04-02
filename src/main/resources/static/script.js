const BASE_URL = "http://localhost:8080";

function login() {
    console.log("LOGIN CLICKED");

    const userInput = document.getElementById("username");
    const passInput = document.getElementById("password");

    if (!userInput || !passInput) {
        alert("Inputs not found");
        return;
    }

    const username = userInput.value;
    const password = passInput.value;

    if (!username || !password) {
        alert("Please enter username and password");
        return;
    }

    fetch("http://localhost:8080/auth/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ username, password })
    })
    .then(res => {
        if (!res.ok) {
            return res.text().then(err => { throw new Error(err); });
        }

        // 🔥 Try JSON first, fallback to text
        return res.text().then(text => {
            try {
                const json = JSON.parse(text);
                return json.token || text;
            } catch {
                return text;
            }
        });
    })
    .then(token => {
        console.log("TOKEN:", token);

        if (!token) {
            alert("Token not received");
            return;
        }

        localStorage.setItem("token", token.trim());

        // ✅ safe redirect
        window.location.href = "/dashboard.html";
    })
    .catch(err => {
        console.error("Login error:", err);
        alert("Login failed");
    });
}

function register() {
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    fetch("http://localhost:8080/auth/register", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ username, password })
    })
    .then(res => res.json())
    .then(() => {
        alert("Registered successfully");
        window.location.href = "/index.html";
    })
    .catch(() => alert("Registration failed"));
}