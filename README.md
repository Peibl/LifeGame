# Autómata celular

Un autómata celular (A.C.) es un modelo matemático para un sistema dinámico que evoluciona en pasos discretos. Es adecuado para modelar sistemas naturales que puedan ser descritos como una colección masiva de objetos simples que interactúen localmente unos con otros.

#  Introducción a las celulas

En la década de 1970, un matemático llamado John Conway publicó una descripción de El juego de la vida, a veces llamado simplemente Vida. "Vida" no era realmente un juego; Se parecía más a una simulación que tomaba una cuadrícula de células (que podían estar vivas o muertas) y les aplicaba algunas reglas sencillas.

Se aplicaron cuatro reglas a cada celda en cada paso de la simulación:

    Si una célula viva tiene menos de dos vecinos vivos, muere.
    Si una célula viva tiene dos o tres vecinos vivos, permanece viva.
    Si una célula viva tiene más de tres vecinos vivos, muere.
    Si una célula muerta tiene exactamente tres vecinos vivos, se vuelve viva.

¡Agradable y simple! Sin embargo, si usted prueba diferentes combinaciones de las redes de partida, puede obtener resultados muy extraños. Lazos infinitos, máquinas que escupen formas, y más. El Juego de la Vida es un ejemplo de un autómata celular - una cuadrícula de células que se rigen por ciertas reglas.

Vamos a implementar un sistema muy similar a la Vida, pero en lugar de producir patrones y formas divertidas, va a crear increíbles sistemas de cuevas para nuestros juegos.