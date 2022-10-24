# Chess-Engine
# But du jeu + Règles 
Le jeu se joue à deux, chaque joueurs est attribué à une couleur (Noir, Blanc). Les blancs sont les premiers à jouer, le but du jeu 
est d'infliger à son adversaire un échec et mat, une situation dans laquelle le roi d'un joueur est en prise sans qu'il soit possible d'y remédier, et 
d'accomplire le maximum de mission.

Règle d'échec classique + ajout de missions:
- Pas bouger la dame
- Pas manger de cavalier 
- Pas de rock
- Faire 2 echec
- Manger la reine ennemie
- Promouvoir un pion (quand elle arrive sur la dernière ligne ennemi
- Pas bouger le roi jusqu'à l'échec
- Manger tous les pions 
- Gagner la partie avec moins de pièce
- Ne pas perdre ses 2 tours

# Déroulé de la partie
Le maitre du jeu commence. Il bouge une pièce, puis transmets le plateau à son adversaire,
qui à son tour, bouge une case et le renvoie au maitre du jeu. Le maitre du jeu vérifie si la partie est terminée.
Si c'est le cas, il en informe son adversaire.

# Fin de la partie
La partie est gagnée par le joueur qui a maté le roi adverse. 
Ceci met immédiatement fin à la partie à condition que le coup produisant la position d'échec et mat soit légal (impossibilité de défendre le roi)
Le vainquer reçoit 100 points et pour chaque mission réaliser reçoit 10 points.
Partie nulle : Une partie est déclarée nulle dans les cas suivants
- si le roi est pat.
- si une pièce occupe trois fois une même position (à la suite ou non).
- si 50 coups sont joués sans prise et sans mouvement de pion.
- si le nombre de pièces est insuffisant pour mettre échec et mat l'adversaire

Impossiblité de mater :
- roi contre roi,
- roi et fou contre roi,
- roi et cavalier contre roi,
- roi et fou contre roi et fou de même couleur.

# Détail des classes principales:
# Protocole réseau :
![197554039-8f9cd025-6eb0-45bc-bde9-9bbddefce130](https://user-images.githubusercontent.com/113866704/197609509-30d4a90e-a520-4ca9-8357-13708e012e2a.png)
