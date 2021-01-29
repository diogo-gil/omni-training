CREATE USER ${k8s.postgres.db.notes.owner.user} with password '${k8s.postgres.db.notes.owner.password}';
CREATE DATABASE notes with owner ${k8s.postgres.db.notes.owner.user} encoding 'UTF8';