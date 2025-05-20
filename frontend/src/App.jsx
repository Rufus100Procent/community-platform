import { useEffect, useState } from 'react';
import './App.css';

function App() {
    const [serverStatus, setServerStatus] = useState('loading');

    const fetchServerStatus = async () => {
        try {
            const res = await fetch('http://localhost:8080/actuator/health');
            const data = await res.json();
            setServerStatus(data.status === 'UP' ? 'up' : 'down');
        } catch {
            setServerStatus('down');
        }
    };

    useEffect(() => {
        fetchServerStatus();
        const interval = setInterval(fetchServerStatus, 30000);
        return () => clearInterval(interval);
    }, []);

    return (
        <>
            <nav className="navbar">
                <div className="nav-brand">Community Platform</div>
                <div className="nav-menu">
                    <a href="#">Dashboard</a>
                    <a href="#">Community</a>
                    <a href="#">Explore Jobs</a>
                    <a href="#">Profile</a>
                    <div className={`status-icon ${serverStatus}`}>
            <span className="status-tooltip">
              {serverStatus === 'loading' ? 'Checking...' : `Server is ${serverStatus.toUpperCase()}`}
            </span>
                    </div>
                </div>
            </nav>

            <main className="container">
                <h2>Welcome to the Community Platform</h2>
                <p>Connect, share, and explore new opportunities.</p>
            </main>
        </>
    );
}

export default App;
