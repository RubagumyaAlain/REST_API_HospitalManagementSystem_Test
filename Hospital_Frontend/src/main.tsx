
import REACTDOM  from 'react-dom/client'
import './index.css'
import App from './App.tsx'
import { StrictMode } from 'react'

REACTDOM.createRoot(document.getElementById('root')!).render(
  <StrictMode>
      <App />
  </StrictMode>
    
  
)
