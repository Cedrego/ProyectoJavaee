# Aquí va la documentación del proyecto =)
modulo de monitoreo pronto solo faltan los tests
estan pronto los test
breve explicacion de como se implementaron los test
@BeforeEach
void setUp() {
    repositorio = mock(RepositorioEventos.class);
    servicio = new ServicioMonitoreoImpl(repositorio);
}

¿Qué hace?

    @BeforeEach:
    Esta anotación indica que el método setUp() se debe ejecutar antes de cada método de prueba (@Test). Sirve para preparar el entorno del test.

    mock(RepositorioEventos.class):
    Esto crea un mock (una simulación) del repositorio. Se está usando probablemente Mockito, una biblioteca popular para pruebas en Java.

        El objetivo de un mock es simular el comportamiento de una clase para que puedas probar otras sin depender de su implementación real (por ejemplo, una base de datos).

    servicio = new ServicioMonitoreoImpl(repositorio);:
    Se crea una instancia del servicio que se quiere probar (ServicioMonitoreoImpl), pasándole el mock del repositorio como dependencia.

        Así puedes probar el servicio sin tener que conectarte a una base de datos real, ya que usas el repositorio simulado.