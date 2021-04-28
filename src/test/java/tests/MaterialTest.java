package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import domain.exceptions.PrendaPoseeArgumentoInvalidoException;
import domain.material.Material;
import domain.material.TipoMaterial;
import domain.material.TramaMaterial;
import domain.prenda.Categoria;

public class MaterialTest {

  @Test
  public void unMaterialPoseeUnColorPrincipal() {
    Material material = new Material("#804000", null, TipoMaterial.CUERO);
    Assertions.assertNotNull(material.getColorPrincipal());
  }

  @Test
  public void unMaterialNoPuedeEstarSinUnColorPrimario() {
    Assertions.assertThrows(PrendaPoseeArgumentoInvalidoException.class,
        () -> new Material(null, "#804000", TipoMaterial.CUERO));
  }

  @Test
  public void unMaterialPuedeEstarSinUnColorSecundario() {
    Material material = new Material("804000", null, TipoMaterial.PLASTICO);
    Assertions.assertNull(material.getColorSecundario());
  }

  @Test
  public void unMaterialPoseeUnColorSecundario() {
    Material material = new Material("804000", "#000000", TipoMaterial.PLASTICO);
    Assertions.assertNotNull(material.getColorSecundario());
  }

  @Test
  public void unMaterialNoPuedeEstarSinUnTipoMaterial() {
    Assertions.assertThrows(PrendaPoseeArgumentoInvalidoException.class,
        () -> new Material("804000", "#A3BF00", null));
  }

  @Test
  public void unMaterialPoseePorDefectoElTramaMaterialComoLiso() {
    Material material = new Material("804000", "#000000", TipoMaterial.PLASTICO);
    Assertions.assertEquals(material.getTramaMaterial(), TramaMaterial.LISA);
  }

  @Test
  public void unaMaterialPuedeCambiarDeTrama() {
    Material material = new Material("804000", "#000000", TipoMaterial.PLASTICO);
    material.setTramaMaterial(TramaMaterial.ACUADROS);
    Assertions.assertEquals(material.getTramaMaterial(), TramaMaterial.ACUADROS);
  }

  @Test
  public void materialNoEsConsistenteConUnTipoDePrenda() {
    Material material = new Material("804000", "#000000", TipoMaterial.PLASTICO);
    Assertions.assertFalse(material.esConsistente(Categoria.PARTEINFERIOR));
  }

  @Test
  public void materialEsConsistenteConUnTipoDePrenda() {
    Material material = new Material("804000", "#000000", TipoMaterial.PLASTICO);
    Assertions.assertTrue(material.esConsistente(Categoria.ACCESORIO));
  }

}
