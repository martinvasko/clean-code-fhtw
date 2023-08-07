import { defineConfig } from 'astro/config';
import tailwind from "@astrojs/tailwind";

import image from "@astrojs/image";

// https://astro.build/config
export default defineConfig({
  site: 'https://martinvasko.github.io',
  base: '/clean-code-fhtw',
  integrations: [tailwind(), image()]
});