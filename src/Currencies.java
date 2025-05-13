import java.util.Currency;
import java.util.Locale;

public final class Currencies {
    private static final Currency US_DOLLAR = Currency.getInstance(Locale.US);
    public static final String US_DOLLAR_CODE = US_DOLLAR.getCurrencyCode();
    public static final String US_DOLLAR_NAME = US_DOLLAR.getDisplayName().toUpperCase();

    private static final Currency EURO = Currency.getInstance(Locale.of("es", "ES"));
    public static final String EURO_CODE = EURO.getCurrencyCode();
    public static final String EURO_NAME = EURO.getDisplayName().toUpperCase();

    private static final Currency ARGENTINE_PESO = Currency.getInstance(Locale.of("es", "AR"));
    public static final String ARGENTINE_PESO_CODE = ARGENTINE_PESO.getCurrencyCode();
    public static final String ARGENTINE_PESO_NAME = ARGENTINE_PESO.getDisplayName().toUpperCase();

    private static final Currency BRAZILIAN_REAL = Currency.getInstance(Locale.of("pt", "BR"));
    public static final String BRAZILIAN_REAL_CODE = BRAZILIAN_REAL.getCurrencyCode();
    public static final String BRAZILIAN_REAL_NAME = BRAZILIAN_REAL.getDisplayName().toUpperCase();

    private static final Currency COLOMBIAN_PESO = Currency.getInstance(Locale.of("es", "CO"));
    public static final String COLOMBIAN_PESO_CODE = COLOMBIAN_PESO.getCurrencyCode();
    public static final String COLOMBIAN_PESO_NAME = COLOMBIAN_PESO.getDisplayName().toUpperCase();

    private static final Currency GUARANI = Currency.getInstance(Locale.of("es", "PY"));
    public static final String GUARANI_CODE = GUARANI.getCurrencyCode();
    public static final String GUARANI_NAME = GUARANI.getDisplayName().toUpperCase();
}
