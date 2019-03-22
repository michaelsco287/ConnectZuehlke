import {Interest} from "./Interest";

export interface Employee {
  firstName: string;
  lastName: string;
  id: number;
  code: string;
  interests: Interest[];
  location: string;
  title: string;
}
