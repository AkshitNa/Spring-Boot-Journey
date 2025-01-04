-- Create the 'users' table
CREATE TABLE users (
    username VARCHAR(50) NOT NULL PRIMARY KEY, -- Unique username for the user
    password VARCHAR(255) NOT NULL,           -- Encrypted (hashed) password
    enabled BOOLEAN NOT NULL                  -- Indicates if the user account is active
);

-- Create the 'authorities' table
CREATE TABLE authorities (
    id SERIAL PRIMARY KEY,                    -- Unique identifier for each authority
    username VARCHAR(50) NOT NULL,            -- Links to the 'users' table
    authority VARCHAR(50) NOT NULL,           -- Role or permission (e.g., ROLE_EMPLOYEE, ROLE_ADMIN)
    FOREIGN KEY (username) REFERENCES users(username) ON DELETE CASCADE
);

