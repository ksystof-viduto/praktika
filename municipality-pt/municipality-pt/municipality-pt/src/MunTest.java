import lt.vtvpmc.municipality.AbstractMunicipalityTest;
import lt.vtvpmc.municipality.Municipality;

public class MunTest extends AbstractMunicipalityTest {
    @Override
    public Municipality getMunicipality() {
        return new MunImpl();
    }
}
