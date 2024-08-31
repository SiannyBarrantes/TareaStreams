import java.util.*;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        List<Pelicula> peliculas = new ArrayList<>();
        peliculas.add(new Pelicula("E.T.", "Steven Spielberg", 1982));
        peliculas.add(new Pelicula("Avatar", "James Cameron", 2009));
        peliculas.add(new Pelicula("Salvar al soldado Ryan", "Steven Spielberg", 1998));
        peliculas.add(new Pelicula("Origen", "Christopher Nolan", 2010));
        peliculas.add(new Pelicula("L.A. Confidential", "Curtis Hanson", 1997));

        System.out.println("\n--- PUNTO 1: Obtener un sublistado con las películas estrenadas en el siglo XXI (a partir del año 2000, inclusive) ---\n");
        List<Pelicula> peliculasXXI = peliculas.stream().filter(p -> p.getEstreno() >= 2000).collect(Collectors.toList());
        for(Pelicula p: peliculasXXI)
        {
            System.out.println(p);
        }

        System.out.println("\n--- PUNTO 2: Mostrar por pantalla, separados por comas, los títulos de las películas de Steven Spielberg ---\n");
        String titulosPeliculas = peliculas.stream()
                .filter(p -> p.getDirector() == "Steven Spielberg")
                .map(p -> p.getTitulo())
                .collect(Collectors.joining(", ",
                        "Peliculas de Steven Spielberg: ", ""));
        System.out.println(titulosPeliculas);

        System.out.println("\n--- PUNTO 3: Obtener un sublistado con los nombres de las películas, ordenados alfabéticamente ---\n");
        Comparator<Pelicula> cTitulo = (p1, p2) -> p1.getTitulo().compareTo(p2.getTitulo());
        List<Pelicula> peliculasOrdenadas = peliculas.stream().sorted(cTitulo).collect(Collectors.toList());
        for(Pelicula p: peliculasOrdenadas)
        {
            System.out.println(p);
        }

    }

}