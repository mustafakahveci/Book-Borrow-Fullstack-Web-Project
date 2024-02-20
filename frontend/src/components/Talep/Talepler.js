import React, { useState } from 'react';
import Talep from './Talep';

const AnaBilesen = () => {
  const [talepler, setTalepler] = useState([
    { baslik: 'Talep 1', icerik: 'Talep 1 İçerik' },
    { baslik: 'Talep 2', icerik: 'Talep 2 İçerik' },
    // Daha fazla talep ekleyebilirsiniz
  ]);

  return (
    <div className="ana-bilesen">
      <h1>Talepler</h1>
      <Talep talepler={talepler} setTalepler={setTalepler} />
    </div>
  );
};

export default AnaBilesen;
