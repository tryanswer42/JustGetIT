UPDATE `users` set
  wachtwoord = '{bcrypt}$2a$10$yXxcEKwK9eiRggZ1L5hHduIrUTW4fMyZnrTN6jmQdvX4gYHJKdyNC'
where login = 'manager';

UPDATE `users` set
  wachtwoord = '{bcrypt}$2a$10$/rUxgaFVmYCKTfD..cSQOOBnbO95RyE8zl6TZ2PQE.q22oTC/2MjK'
where login = 'bediende';
