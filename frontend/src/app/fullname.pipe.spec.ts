import {FullnamePipe} from './fullname.pipe';

describe('FullnamePipe', () => {
  it('create an instance', () => {
    const pipe = new FullnamePipe();
    expect(pipe).toBeTruthy();
  });

  it("returns an employee's fullname", () => {
    const pipe = new FullnamePipe();
    const employee = {id: 0, code: "tote", firstName: "Tommy", lastName: "Tester", interests: [], title: "tester", location: "hollow"};
    expect(pipe.transform(employee)).toBe("Tommy Tester")
  })
});
