import { useState } from 'react';

export default function Login() {
  const [email, setEmail] = useState('');
  const [senha, setSenha] = useState('');

  const handleLogin = (e: React.FormEvent) => {
    e.preventDefault();
    console.log('Tentativa de login com:', { email, senha });
    // TODO: Integrar com a API do Spring Boot futuramente
  };

  return (
    <div style={{ display: 'flex', justifyContent: 'center', alignItems: 'center', height: '100vh', backgroundColor: '#f0f2f5' }}>
      <form onSubmit={handleLogin} style={{ display: 'flex', flexDirection: 'column', gap: '1rem', padding: '2rem', backgroundColor: 'white', borderRadius: '8px', boxShadow: '0 4px 6px rgba(0,0,0,0.1)', width: '300px' }}>
        <h2 style={{ textAlign: 'center', margin: 0, color: '#333' }}>HelpDesk Pro</h2>
        
        <div>
          <label htmlFor="email" style={{ display: 'block', marginBottom: '0.5rem', fontSize: '0.875rem', color: '#666' }}>E-mail</label>
          <input 
            type="email" 
            id="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            style={{ width: '100%', padding: '0.5rem', border: '1px solid #ccc', borderRadius: '4px', boxSizing: 'border-box' }}
            required
          />
        </div>

        <div>
          <label htmlFor="senha" style={{ display: 'block', marginBottom: '0.5rem', fontSize: '0.875rem', color: '#666' }}>Senha</label>
          <input 
            type="password" 
            id="senha"
            value={senha}
            onChange={(e) => setSenha(e.target.value)}
            style={{ width: '100%', padding: '0.5rem', border: '1px solid #ccc', borderRadius: '4px', boxSizing: 'border-box' }}
            required
          />
        </div>

        <button type="submit" style={{ padding: '0.75rem', backgroundColor: '#007bff', color: 'white', border: 'none', borderRadius: '4px', cursor: 'pointer', fontWeight: 'bold' }}>
          Entrar
        </button>
      </form>
    </div>
  );
}