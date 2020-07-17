export abstract class Movie {
    private title: string;

    public constructor(title: string) {
        this.title = title;
    }

    public getTitle(): string {
        return this.title;
    }

    public abstract calculateRentalPrice(dayRented: number);
}

// tslint:disable-next-line:max-classes-per-file
export class RegularMovie extends Movie {
    public constructor(title: string) {
        super(title);
    }
    public calculateRentalPrice(dayRented: number) {
        return dayRented > 2 ? ((dayRented - 2) * 1.5) + 2 : 2;
    }
}
// tslint:disable-next-line:max-classes-per-file
export class NewReleaseMovie extends Movie {
    public constructor(title: string) {
        super(title);
    }
    public calculateRentalPrice(dayRented: number) {
        return dayRented * 3;
    }
}

// tslint:disable-next-line:max-classes-per-file
export class ChildrenMovie extends Movie {
    public constructor(title: string) {
        super(title);
    }
    public calculateRentalPrice(dayRented: number) {
        return dayRented > 3 ? ((dayRented - 3) * 1.5) + 1.5 : 1.5;
    }
}
