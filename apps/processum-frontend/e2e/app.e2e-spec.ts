import { ProcessumWebStarterPage } from './app.po';

describe('processum-web-starter App', function() {
  let page: ProcessumWebStarterPage;

  beforeEach(() => {
    page = new ProcessumWebStarterPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
