public class HTMLButton implements Button {
    private String text;

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void render() {
        System.out.println("<button>" + text + "</button>");
    }
}