import * as components from "vuetify/components";
import * as directives from "vuetify/directives";
import { createVuetify } from "vuetify";
import { aliases, mdi } from "vuetify/iconsets/mdi";

const theme = {
  defaultTheme: "kniffelTheme",
  themes: {
    kniffelTheme: {
      dark: true,
      colors: {
        background: "#111111",
        surface: "#2e2e2e",
        primary: "#002445",
        secondary: "#757575",
        error: "#d40000",
        info: "#0083d4",
        success: "#23d400",
        warning: "#d43c00",
      },
    },
  },
};

const icons = {
  defaultSet: "mdi",
  aliases: aliases,
  sets: {
    mdi: mdi,
  },
};

export default createVuetify({
  theme: theme,
  icons: icons,
  components: components,
  directives: directives,
});
