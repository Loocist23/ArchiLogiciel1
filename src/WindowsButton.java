public class WindowsButton implements Button {
    private String text;

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void render() {
        System.out.println("Rendering Windows Button with text: " + text);
    }
}