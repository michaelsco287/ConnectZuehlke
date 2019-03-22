import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
  name: 'groupByLocation'
})
export class GroupByLocationPipe implements PipeTransform {

  transform(collection: Array): Array {
    // prevents the application from breaking if the array of objects doesn't exist yet
    if (!collection) {
      return null;
    }

    const groupedCollection = collection.reduce((previous, current) => {
      if (!previous[current["location"]]) {
        previous[current["location"]] = [current];
      } else {
        previous[current["location"]].push(current);
      }

      return previous;
    }, {});

    // this will return an array of objects, each object containing a group of objects
    return Object.keys(groupedCollection).map(key => ({key, value: groupedCollection[key]}));
  }

}
