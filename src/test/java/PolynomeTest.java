import com.example.interpolation.math.InterpolatingLagrangePolynomial;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;

public class PolynomeTest {
    final InterpolatingLagrangePolynomial interpolatingLagrangePolynomial = new InterpolatingLagrangePolynomial();
    @Test
    public void basicCaseTest() {
        double y = interpolatingLagrangePolynomial.calculate(List.of(0.0, 2.0, 3.0, 5.0), List.of(0.0, 1.0, 3.0, 2.0), 1.0);
        assert Objects.equals(String.format("%.2f", y), String.valueOf(-0.53d));
    }
}
